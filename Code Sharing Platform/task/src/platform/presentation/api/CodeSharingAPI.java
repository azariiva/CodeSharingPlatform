package platform.presentation.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import platform.presentation.entity.CodeJBean;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/api/code")
public interface CodeSharingAPI {

    @PostMapping(path = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    Map<String, Object> createCode(@RequestBody CodeJBean code);

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    CodeJBean readCode(@PathVariable("id") UUID id);

    @GetMapping(path = "/latest", produces = MediaType.APPLICATION_JSON_VALUE)
    Collection<CodeJBean> readLatestCode();
}
