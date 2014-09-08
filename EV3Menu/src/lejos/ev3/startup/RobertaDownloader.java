package lejos.ev3.startup;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import lejos.utility.Delay;

/**
 * @author dpyka
 */
public class RobertaDownloader implements Runnable {

    private HttpURLConnection httpURLConnection;

    private final URL serverURL;
    private final String token;

    private final String PROGRAMS_DIRECTORY = "/home/lejos/programs";

    public RobertaDownloader(URL serverURL, String token) {
        this.serverURL = serverURL;
        this.token = token;
    }

    public HttpURLConnection getHttpConnection() {
        return this.httpURLConnection;
    }

    @Override
    public void run() {
        while ( true ) {
            if ( RobertaObserver.isExecuted() == true && RobertaObserver.isDownloaded() == false ) {

                DataOutputStream dos = null;
                InputStream is = null;
                FileOutputStream fos = null;

                try {
                    this.httpURLConnection = openConnection(this.serverURL);

                    dos = new DataOutputStream(this.httpURLConnection.getOutputStream());
                    dos.writeBytes(this.token);
                    dos.flush();

                    is = this.httpURLConnection.getInputStream();
                    byte[] buffer = new byte[4096];
                    int n;

                    RobertaObserver.setUserFileName(this.httpURLConnection.getHeaderField("fileName"));
                    System.out.println("http header fileName: " + RobertaObserver.getUserFileName());
                    fos = new FileOutputStream(new File(this.PROGRAMS_DIRECTORY, RobertaObserver.getUserFileName()));

                    while ( (n = is.read(buffer)) != -1 ) {
                        fos.write(buffer, 0, n);
                    }
                    RobertaObserver.setDownloaded(true);
                } catch ( IOException e ) {
                    System.out.println("force disconnect (download)");
                } finally {
                    try {
                        if ( dos != null ) {
                            dos.close();
                        }
                        if ( is != null ) {
                            is.close();
                        }
                        if ( fos != null ) {
                            fos.close();
                        }
                    } catch ( IOException e ) {
                    }
                }
            } else {
                Delay.msDelay(500);
            }
        }
    }

    /**
     * Opens http connection to server. "POST" as request method. Input, output
     * set to "true".
     * no readTimeOut, connection will be hold forever or until data was send or until force disconnect
     * 
     * @param url
     *        the robertalab server url or ip+port
     * @return httpURLConnection http connection object to the server
     * @throws IOException
     *         opening a connection failed
     */
    private HttpURLConnection openConnection(URL serverURL) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) serverURL.openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(0);
        return httpURLConnection;
    }

}