package api;

import utils.APIUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import listeners.TestListener;

@Listeners(TestListener.class)
public class RestAssuredBasicsTest {

	@Test (priority = 1)
	public void apiUtilsGetTest() {

		Response response = APIUtils.get("/posts/5");

		System.out.println(response.asPrettyString());
	}

	@Test (priority = 2)
	public void apiUtilsPostTest() {

		String requestBody = "{" + "\"id\": 101," + "\"title\": \"API Framework Test\","
				+ "\"body\": \"Testing reusable POST method\"," + "\"userId\": 1" + "}";

		Response response = APIUtils.post("/posts", requestBody);

		System.out.println(response.asPrettyString());
	}

	@Test (priority = 3)
	public void apiUtilsPutTest() {

		String requestBody = "{" + "\"id\": 1," + "\"title\": \"Updated Through Utility\","
				+ "\"body\": \"Testing reusable PUT method\"," + "\"userId\": 1" + "}";

		Response response = APIUtils.put("/posts/1", requestBody);

		System.out.println(response.asPrettyString());
	}

	@Test (priority = 4)
	public void apiUtilsDeleteTest() {

		Response response = APIUtils.delete("/posts/1");

		System.out.println(response.asPrettyString());
	}
}
