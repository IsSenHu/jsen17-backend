package com.jsen17.ssh.agent.controller;

import com.jsen17.ssh.agent.core.CommandExecutor;
import com.jsen17.ssh.agent.dto.ExecRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Husen
 * @since 2022/11/30 22:15
 */
@RestController
@RequestMapping("/v1/ssh")
public class SshController {

    private final CommandExecutor commandExecutor;

    public SshController(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @PostMapping
    public void exec(@RequestBody ExecRequest request, HttpServletResponse response) throws IOException {
        commandExecutor.exec(request.getCommand(), response.getOutputStream());
    }
}
