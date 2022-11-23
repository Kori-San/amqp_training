package fr.lernejo.chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/message")
public class ChatMessageController {
    private final ChatMessageRepository repository;

    public ChatMessageController(ChatMessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<String> message() {
        return repository.getLastTenMessages();
    }
}
