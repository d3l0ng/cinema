package com.longosz.cinema.e2e


import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc(addFilters = false)
class EndToEndTest extends Specification {

    @Autowired
    MockMvc mvc

    def "should get screenings once they have been added"() {
        given: "sceenings post request"
        def screenings = '''
            [
              {
                "movieId": "123",
                "showTime": "2020-11-10T15:30:00",
                "ticketPrice": 123.12
              },
              
              {
                "movieId": "234",
                "showTime": "2020-11-11T15:30:00",
                "ticketPrice": 34.00
              }
            ]
            '''

        when: "getting empty screenings"
        def emptyResponse = mvc.perform(MockMvcRequestBuilders.get("/api/screenings"))
                .andReturn()
                .response

        def emptyContent = new JsonSlurper().parseText(emptyResponse.contentAsString)

        then: "it should receive empty screenings"
        emptyContent == []

        when: "screenings are added"
        mvc.perform(MockMvcRequestBuilders.post("/admin/screenings")
                .contentType(MediaType.APPLICATION_JSON)
                .content(screenings)
                .characterEncoding("utf-8"))
        def response = mvc.perform(MockMvcRequestBuilders.get("/api/screenings"))
                .andReturn()
                .response

        def content = response.contentAsString

        then: "screenings are properly queried"
        content == screenings.replaceAll("\\s","")
    }
}