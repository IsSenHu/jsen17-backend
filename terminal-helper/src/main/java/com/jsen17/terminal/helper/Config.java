package com.jsen17.terminal.helper;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Husen
 * @since 2022/11/26 22:47
 */
@Data
public class Config {
    private List<Host> hosts = new ArrayList<>();
}
