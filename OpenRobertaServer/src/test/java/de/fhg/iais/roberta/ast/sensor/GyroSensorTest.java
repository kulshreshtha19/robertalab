package de.fhg.iais.roberta.ast.sensor;

import org.junit.Assert;
import org.junit.Test;

import de.fhg.iais.roberta.ast.syntax.codeGeneration.Helper;
import de.fhg.iais.roberta.ast.syntax.sensor.GyroSensor;
import de.fhg.iais.roberta.ast.syntax.sensor.GyroSensorMode;
import de.fhg.iais.roberta.ast.syntax.sensor.SensorPort;
import de.fhg.iais.roberta.ast.transformer.JaxbTransformer;

public class GyroSensorTest {

    @Test
    public void sensorSetGyro() throws Exception {
        String a = "BlockAST [project=[[GyroSensor [mode=ANGLE, port=S2]]]]";

        Assert.assertEquals(a, Helper.generateTransformerString("/ast/sensors/sensor_setGyro.xml"));
    }

    @Test
    public void getMode() throws Exception {
        JaxbTransformer<Void> transformer = Helper.generateTransformer("/ast/sensors/sensor_setGyro.xml");

        GyroSensor<Void> cs = (GyroSensor<Void>) transformer.getTree().get(0);

        Assert.assertEquals(GyroSensorMode.ANGLE, cs.getMode());
    }

    @Test
    public void getPort() throws Exception {
        JaxbTransformer<Void> transformer = Helper.generateTransformer("/ast/sensors/sensor_setGyro.xml");

        GyroSensor<Void> cs = (GyroSensor<Void>) transformer.getTree().get(0);

        Assert.assertEquals(SensorPort.S2, cs.getPort());
    }

    @Test
    public void sensorGetModeGyro() throws Exception {
        String a = "BlockAST [project=[[GyroSensor [mode=GET_MODE, port=S2]]]]";

        Assert.assertEquals(a, Helper.generateTransformerString("/ast/sensors/sensor_getModeGyro.xml"));
    }

    @Test
    public void sensorGetSampleGyro() throws Exception {
        String a = "BlockAST [project=[[GyroSensor [mode=GET_SAMPLE, port=S2]]]]";

        Assert.assertEquals(a, Helper.generateTransformerString("/ast/sensors/sensor_getSampleGyro.xml"));
    }

    @Test
    public void sensorResetGyro() throws Exception {
        String a = "BlockAST [project=[[GyroSensor [mode=RESET, port=S2]]]]";

        Assert.assertEquals(a, Helper.generateTransformerString("/ast/sensors/sensor_resetGyro.xml"));
    }

}