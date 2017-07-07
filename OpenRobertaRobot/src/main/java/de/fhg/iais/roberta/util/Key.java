package de.fhg.iais.roberta.util;

public enum Key {
    SERVER_ERROR(),
    COMMAND_INVALID(),
    INIT_SUCCESS(),
    TOKEN_SET_SUCCESS(),
    TOKEN_SET_ERROR_NO_ROBOT_WAITING(),
    TOKEN_SET_ERROR_WRONG_ROBOTTYPE(),
    TOOLBOX_ERROR_ID_INVALID(),
    TOOLBOX_GET_ONE_ERROR_NOT_FOUND(),
    TOOLBOX_GET_ONE_SUCCESS(),
    TOOLBOX_SAVE_ERROR(),
    TOOLBOX_SAVE_SUCCESS(),
    TOOLBOX_GET_ALL_SUCCESS(),
    TOOLBOX_DELETE_SUCCESS(),
    TOOLBOX_DELETE_ERROR(),
    TOOLBOX_TRANSFORM_ERROR(),
    TOOLBOX_SAVE_ERROR_NOT_SAVED_TO_DB(),
    ROBOT_PUSH_RUN(),
    ROBOT_NOT_WAITING(),
    ROBOT_FIRMWAREUPDATE_POSSIBLE(),
    ROBOT_FIRMWAREUPDATE_IMPOSSIBLE(),
    ROBOT_NOT_CONNECTED(),
    ROBOT_SET_SUCCESS(),
    CONFIGURATION_ERROR_ID_INVALID(),
    CONFIGURATION_GET_ONE_ERROR_NOT_FOUND(),
    CONFIGURATION_GET_ONE_SUCCESS(),
    CONFIGURATION_SAVE_ERROR(),
    CONFIGURATION_SAVE_SUCCESS(),
    CONFIGURATION_GET_ALL_SUCCESS(),
    CONFIGURATION_DELETE_SUCCESS(),
    CONFIGURATION_DELETE_ERROR(),
    CONFIGURATION_TRANSFORM_ERROR(),
    CONFIGURATION_SAVE_ERROR_NOT_SAVED_TO_DB(),
    PROGRAM_ERROR_ID_INVALID(),
    PROGRAM_GET_ONE_SUCCESS(),
    PROGRAM_GET_ONE_ERROR_NOT_FOUND,
    PROGRAM_GET_ONE_ERROR_NOT_LOGGED_IN,
    PROGRAM_IMPORT_ERROR,
    PROGRAM_IMPORT_ERROR_WRONG_ROBOT_TYPE(),
    PROGRAM_IMPORT_SUCCESS,
    PROGRAM_SAVE_AS_ERROR_PROGRAM_EXISTS,
    PROGRAM_SAVE_ERROR_NO_WRITE_PERMISSION,
    PROGRAM_SAVE_ERROR_OPTIMISTIC_TIMESTAMP_LOCKING,
    PROGRAM_SAVE_ERROR_PROGRAM_TO_UPDATE_NOT_FOUND,
    PROGRAM_SAVE_SUCCESS,
    PROGRAM_GET_ALL_SUCCESS,
    PROGRAM_DELETE_SUCCESS,
    PROGRAM_DELETE_ERROR,
    PROGRAM_CONFIGURATION_NOT_COMPATIBLE,
    USER_ERROR_NOT_LOGGED_IN,
    USER_LOGOUT_SUCCESS,
    USER_GET_ONE_SUCCESS,
    USER_EMAIL_ONE_SUCCESS,
    USER_EMAIL_ONE_ERROR_USER_NOT_EXISTS_WITH_THIS_EMAIL,
    USER_GET_ONE_ERROR_ID_OR_PASSWORD_WRONG,
    USER_CREATE_SUCCESS,
    USER_UPDATE_SUCCESS,
    USER_ACTIVATION_SUCCESS,
    USER_DEACTIVATION_SUCCESS,
    USER_UPDATE_ERROR_ACCOUNT_WRONG,
    USER_UPDATE_ERROR_NOT_SAVED_TO_DB,
    USER_CREATE_ERROR_MISSING_REQ_FIELDS,
    USER_CREATE_ERROR_CONTAINS_SPECIAL_CHARACTERS,
    USER_CREATE_ERROR_ACCOUNT_LENGTH,
    USER_CREATE_ERROR_GENERATE_CONFIRMATION,
    USER_CREATE_GENERATE_CONFIRMATION_SUCCESS,
    USER_CREATE_GENERATE_CONFIRMATION_URL_USERID_NOT_SAVED_IN_DATABASE,
    USER_ACTIVATION_INVALID_URL,
    USER_ACTIVATION_WRONG_ACCOUNT,
    USER_ERROR_EMAIL_USED,
    USER_CREATE_ERROR_NOT_SAVED_TO_DB,
    USER_DELETE_SUCCESS,
    USER_DELETE_ERROR_NOT_DELETED_IN_DB,
    USER_DELETE_ERROR_ID_NOT_FOUND,
    USER_GET_ALL_SUCCESS,
    USER_PASSWORD_RECOVERY_GENERATE_URL_SUCCESS,
    USER_PASSWORD_RECOVERY_GENERATE_URL_USERID_ERROR,
    USER_PASSWORD_RECOVERY_GENERATE_URL_USERID_NOT_SAVED_IN_DATABASE,
    USER_PASSWORD_RECOVERY_INVALID_URL,
    USER_PASSWORD_RECOVERY_EXPIRED_URL,
    USER_DANGEROUS_SYMBOLS,
    OWNER_DOES_NOT_EXIST,
    ROBOT_DOES_NOT_EXIST,
    PROGRAM_TO_SHARE_DOES_NOT_EXIST,
    USER_TO_SHARE_DOES_NOT_EXIST,
    ACCOUNT_NOT_ACTIVATED_TO_SHARE,
    COMPILERWORKFLOW_SUCCESS,
    COMPILERWORKFLOW_ERROR_PROGRAM_NOT_FOUND,
    COMPILERWORKFLOW_ERROR_CONFIGURATION_NOT_FOUND,
    COMPILERWORKFLOW_ERROR_PROGRAM_TRANSFORM_FAILED,
    COMPILERWORKFLOW_ERROR_CONFIGURATION_TRANSFORM_FAILED,
    COMPILERWORKFLOW_ERROR_PROGRAM_STORE_FAILED,
    COMPILERWORKFLOW_ERROR_PROGRAM_COMPILE_FAILED,
    COMPILERWORKFLOW_ERROR_PROGRAM_GENERATION_FAILED,
    COMPILERWORKFLOW_PROGRAM_GENERATION_SUCCESS,
    ACCESS_RIGHT_CHANGED,
    ACCESS_RIGHT_DELETED,
    USER_PASSWORD_RECOVERY_SENT_MAIL_FAIL,
    USER_PASSWORD_RECOVERY_SENT_MAIL_SUCCESS,
    USER_ACTIVATION_SENT_MAIL_FAIL,
    USER_ACTIVATION_SENT_MAIL_SUCCESS;

    private Key() {
        this.key = "ORA_" + this.toString();
    }

    private Key(String key) {
        this.key = key;
    }

    private final String key;

    /**
     * get the key string. This string is looked up in a message table supplied by blockly. Blockly is running in the frontend. Thus, the typical use is:<br>
     * - return from somewhere in the server an enum object<br>
     * - the REST services (or their helper methods) take the key string and embed it into a JSON object returned to the (javascript) client<br>
     * - the client uses a language specific map to get the real message
     */
    public String getKey() {
        return this.key;
    }
}
