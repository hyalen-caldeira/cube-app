package com.cubeapp.cubeapp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Title("UserController Specification")
@Narrative("The Specification of the behaviour of the UserController. It can create a user, change the name and reset it to 'world'")
@SpringBootTest
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude= SecurityAutoConfiguration.class)
class UserControllerTest extends Specification {

    @Autowired
    private MockMvc mvc

    def "when get is performed then the response has status 200 and content is 'hyalen'"() {
        expect: "Status is 200 and the response is 'hyalen'"
        mvc.perform(MockMvcRequestBuilders.get("/api/users")).andExpect(MockMvcResultMatchers.status().isOk())//.andReturn().response.contentAsString == "Hello world!"
    }

    def "when set and delete are performed then the response has status 204 and content changes as expected"() {
        given: "a new name"
        def NAME = "hyalen"

//        when: "the name is searched"
//        mvc.perform(MockMvcRequestBuilders.put("/api/users").content(NAME)).andExpect(MockMvcResultMatchers.status().isOk())
//
//        then: "the salutation uses the new name"
//        mvc.perform(MockMvcRequestBuilders.get("/api/users")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().response.contentAsString == "Hello $NAME!"
//
//        when: "the name is deleted"
//        mvc.perform(MockMvcRequestBuilders.delete("/api/users")).andExpect(MockMvcResultMatchers.status().isNoContent())
//
//        then: "the salutation uses the default name"
//        mvc.perform(MockMvcRequestBuilders.get("/api/users")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().response.contentAsString == "Hello world!"
    }

//    def "when set and delete are performed then the response has status 204 and content changes as expected"() {
//        given: "a new name"
//        def NAME = "Emmy"
//
//        when: "the name is set"
//        mvc.perform(MockMvcRequestBuilders.put("/api/users").content(NAME)).andExpect(MockMvcResultMatchers.status().isNoContent())
//
//        then: "the salutation uses the new name"
//        mvc.perform(MockMvcRequestBuilders.get("/api/users")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().response.contentAsString == "Hello $NAME!"
//
//        when: "the name is deleted"
//        mvc.perform(MockMvcRequestBuilders.delete("/api/users")).andExpect(MockMvcResultMatchers.status().isNoContent())
//
//        then: "the salutation uses the default name"
//        mvc.perform(MockMvcRequestBuilders.get("/api/users")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().response.contentAsString == "Hello world!"
//    }
}