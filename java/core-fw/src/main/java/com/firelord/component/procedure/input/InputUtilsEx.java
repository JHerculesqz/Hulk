package com.firelord.component.procedure.input;

import java.util.Objects;
import java.util.Optional;

/**
 * InputUtilsEx
 */
public class InputUtilsEx {
    //#region validate

    /**
     * checkNotNull Wrapper
     *
     * @param obj the object reference to check for nullity
     * @param <T> the type of the reference
     * @return {@code obj} if not {@code null}
     * @throws NullPointerException if {@code obj} is {@code null}
     */
    public static <T> T checkNotNull(T obj) {
        return Objects.requireNonNull(obj);
    }

    /**
     * checkNotNull Wrapper
     *
     * @param obj     the object reference to check for nullity
     * @param message detail message to be used in the event that a {@code
     *                NullPointerException} is thrown
     * @param <T>     the type of the reference
     * @return {@code obj} if not {@code null}
     * @throws NullPointerException if {@code obj} is {@code null}
     */
    public static <T> T checkNotNull(T obj, String message) {
        return Objects.requireNonNull(obj, message);
    }

    /**
     * checkExpress wrapper
     *
     * @param express express
     * @throws IllegalArgumentException if {@code express} is {@code false}
     */
    public static void checkExpress(boolean express) {
        if (!express) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * checkExpress wrapper
     *
     * @param express express
     * @param message detail message to be used in the event that a {@code
     *                IllegalArgumentException} is thrown
     */
    public static void checkExpress(boolean express, String message) {
        if (!express) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Return the value if present, otherwise return {@code defaultVal}.
     *
     * @param obj        the possibly-null value to describe
     * @param defaultVal the value to be returned if there is no value present, may be null
     * @param <T>        the type of the reference
     * @return the value, if present, otherwise {@code defaultVal}
     */
    public static <T> T checkNullOrSetDefaultVal(T obj, T defaultVal) {
        return Optional.ofNullable(obj).orElse(defaultVal);
    }



    //#endregion
}
