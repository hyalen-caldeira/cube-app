package com.cubeapp.cubeapp.core.web;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.cubeapp.cubeapp.core.ApiResponse;
import com.cubeapp.cubeapp.core.dto.UserDto;
import com.cubeapp.cubeapp.core.service.UserService;
import com.cubeapp.cubeapp.model.UserModel;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@RestController("userController_v1")
@RequestMapping(value = "/api/users", produces = UserDto.MEDIA_TYPE)
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        var list = service.getAllUsers();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<UserDto> getUserByName(@PathVariable(value = "name") String name) {
        UserDto UserDto = service.findByName(name);
        return ok(UserDto);
    }

    @PutMapping(value = "/{name}", consumes = UserDto.MEDIA_TYPE)
    public void update(@Valid @RequestBody UserDto dto, @PathVariable(value = "name") String name) {
        service.findByName(name);
        service.update(dto);
    }

    @PostMapping(consumes = UserDto.MEDIA_TYPE)
    // public void create(@Valid @RequestBody UserResource resource, HttpServletResponse httpServletResponse) {
    public ResponseEntity<?> create(@Valid @RequestBody UserDto dto) {
        dto = service.create(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{name}")
                .buildAndExpand(dto.getName()).toUri();

        return created(location).body(new ApiResponse(true, ApiResponse.CREATED));

        // httpServletResponse.setHeader("Location", fromMethodCall(on(getClass()).getUserById(dto.getId())).build().toString());
    }

    @DeleteMapping(value = "/{name}")
    public ResponseEntity<?> delete(@PathVariable(value = "name") String name) {
        service.findByName(name);
//        service.delete();

        // Not using swagger version of API response
        return ok(new ApiResponse(true, ApiResponse.DELETED));
    }
}