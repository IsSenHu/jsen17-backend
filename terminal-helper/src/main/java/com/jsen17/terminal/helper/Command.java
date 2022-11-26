package com.jsen17.terminal.helper;

import com.jsen17.terminal.helper.impl.AddHostCommandProcessor;
import com.jsen17.terminal.helper.impl.LoginCommandProcessor;

/**
 * @author Husen
 * @since 2022/11/26 22:54
 */
public enum Command {
    ADD_HOST(new AddHostCommandProcessor()),
    LOGIN(new LoginCommandProcessor());

    private final CommandProcessor processor;

    Command(CommandProcessor processor) {
        this.processor = processor;
    }

    public CommandProcessor getProcessor() {
        return processor;
    }
}
