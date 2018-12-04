package apiTests;

import api.ApiHelper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class ApiTest {

    private ApiHelper apiHelper = new ApiHelper();

    @Test
    public void apiTest(){
        //given
        apiHelper.goToBaseUrl("/users")

            //expect
                .statusCode(200)
                .assertThat().body("id", Matchers.hasItem(9))
                .assertThat().body("company[8].name", Matchers.equalTo("Yost and Sons"))
                .extract().response().prettyPrint();
    }

}
