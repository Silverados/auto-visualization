package xyz.wywag.cars.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {

    private static final Logger logger = LoggerFactory.getLogger("xyz.wywag");

    /**
     * trace level log
     *
     * @param msg
     */
    public static void trace(Object msg){
        logger.trace(msg.toString());
    }

    /**
     * trace level log with throwable
     *
     * @param msg
     * @param t
     */
    public static void trace(Object msg, Throwable t){
        logger.trace(msg.toString(), t);
    }

    /**
     * debug level log
     *
     * @param msg
     */
    public static void debug(Object msg){
        logger.debug(msg.toString());
    }

    /**
     * debug level log with throwable
     *
     * @param msg
     * @param t
     */
    public static void debug(Object msg, Throwable t){
        logger.debug(msg.toString(), t);
    }

    /**
     * info level log
     *
     * @param msg
     */
    public static void info(Object msg){
        logger.info(msg.toString());
    }

    /**
     * info level log with throwable
     *
     * @param msg
     * @param t
     */
    public static void info(Object msg, Throwable t){
        logger.info(msg.toString(), t);
    }

    /**
     * warn level log
     *
     * @param msg
     */
    public static void warn(Object msg){
        logger.warn(msg.toString());
    }

    /**
     * warn level log with throwable
     *
     * @param msg
     * @param t
     */
    public static void warn(Object msg, Throwable t){
        logger.warn(msg.toString(), t);
    }

    /**
     * error level msg
     *
     * @param msg
     */
    public static void error(Object msg){
        logger.error(msg.toString());
    }

    /**
     * error level msg with throwable
     *
     * @param msg
     * @param t
     */
    public static void error(Object msg, Throwable t){
        logger.error(msg.toString(), t);
    }
}

