package com.firelord.component.procedure.output;

import org.apache.poi.ss.formula.functions.T;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * OutputUtilsEx
 */
public class OutputUtilsEx {
    //#region getReuslt

    /**
     * Returns an {@code Optional} describing the specified value, if non-null, otherwise returns an empty {@code Optional}.
     *
     * @param <T>   the class of the value
     * @param value the possibly-null value to describe
     * @return an {@code Optional} with a present value if the specified value
     * is non-null, otherwise an empty {@code Optional}
     */
    public static <T> Optional<T> getReuslt(T value) {
        return Optional.ofNullable(value);
    }

    //#endregion

    //#region ifPresent

    /**
     * If a value is present, invoke the specified consumer with the value, otherwise do nothing.
     *
     * @param optionalObj Optional Object
     * @param consumer    block to be executed if a value is present
     * @throws NullPointerException if value is present and {@code consumer} is null
     */
    public static void ifPresent(Optional<T> optionalObj, Consumer<? super T> consumer) {
        optionalObj.ifPresent(consumer);
    }

    //#endregion

    //#region isPresent

    /**
     * If a value is present, invoke the specified consumer with the value,
     * otherwise do nothing.
     *
     * @param optionalObj Optional Object
     * @param optionalObj block to be executed if a value is present
     * @throws NullPointerException if value is present and {@code consumer} is null
     */
    public static boolean isPresent(Optional<T> optionalObj) {
        return optionalObj.isPresent();
    }

    //#endregion
}
