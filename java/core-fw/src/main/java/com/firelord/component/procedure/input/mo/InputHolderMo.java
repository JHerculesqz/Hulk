package com.firelord.component.procedure.input.mo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Holds a value of type <code>T</code>.
 */
public class InputHolderMo<T> implements Serializable {
    //#region Fields

    /**
     * value in Holder
     */
    @Setter
    @Getter
    private T value;

    //#endregion

    //#region Construction

    private InputHolderMo() {
    }

    /**
     * Create a new holder with the specified value.
     *
     * @param value The value to be stored in the holder.
     */
    public InputHolderMo(T value) {
        this.value = value;
    }

    //#endregion
}
