package com.iiht.training.auction.functional;

import static com.iiht.training.auction.testutils.TestUtils.businessTestFile;
import static com.iiht.training.auction.testutils.TestUtils.currentTest;
import static com.iiht.training.auction.testutils.TestUtils.testReport;
import static com.iiht.training.auction.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.iiht.training.auction.controller.SellerController;
import com.iiht.training.auction.dto.BidsDto;
import com.iiht.training.auction.dto.SellerDto;
import com.iiht.training.auction.service.BidsService;
import com.iiht.training.auction.service.SellerService;
import com.iiht.training.auction.testutils.MasterData;

@WebMvcTest(SellerController.class)
@AutoConfigureMockMvc
public class SellerControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SellerService sellerService;
	@MockBean
	private BidsService bidsService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	

	@Test
	public void testGetSellerById() throws Exception {
		SellerDto sellerDto = MasterData.getSellerDto();
		when(this.sellerService.getSellerById(1L)).thenReturn(sellerDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/sellers/get/1")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(sellerDto)) ? "true"
						: "false"),
				businessTestFile);

	}

	
}
