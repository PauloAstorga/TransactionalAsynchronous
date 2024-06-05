package cl.pastorga.pad.constants;

public class ControllerConstants {
    
    public static final String MAIN_CONTROLLER_ENDPOINT = "/";
    public static final String MAIN_CONTROLLER_DEFAULT_GET = "/default-get/{message}";
    public static final String MAIN_CONTROLLER_DEFAULT_POST = "/default-post/{message}";

    public static final String ASYNC_CONTROLLER_ENDPOINT = "/async";
    public static final String ASYNC_CONTROLLER_INSERT = ASYNC_CONTROLLER_ENDPOINT + "/transactional/insert/{asyncEntityName}";
    public static final String ASYNC_CONTROLLER_TRANSACTIONAL = ASYNC_CONTROLLER_ENDPOINT + "/transactional/{randomInt}";
    public static final String ASYNC_CONTROLLER_GET_ALL = ASYNC_CONTROLLER_ENDPOINT + "/transactional/all";

}
