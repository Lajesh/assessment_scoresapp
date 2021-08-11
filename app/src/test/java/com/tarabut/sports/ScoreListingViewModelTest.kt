package com.tarabut.sports

import com.tarabut.sports.base.BaseTest
import com.tarabut.domain.usecases.products.IScoresUseCase
import com.tarabut.scores.view.fragment.products.ScoresListingViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.test.inject
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit

/****
 * Unit test for LogiViewModel
 * Author: Lajesh Dineshkumar
 *****/
@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class ScoreListingViewModelTest : BaseTest() {

    private lateinit var scoresListingViewModel: ScoresListingViewModel

    //Inject api service created with koin
    private val scoresUseCase: IScoresUseCase by inject()

    //Inject Mockwebserver created with koin
    private val mockWebServer: MockWebServer by inject()

    private val testDispatcher = TestCoroutineDispatcher()


    override fun setUp() {
        super.setUp()
        scoresListingViewModel = ScoresListingViewModel(scoresUseCase)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun test_product_lisiting_success_case() = runBlocking {
        mockNetworkResponseWithFileContent("success.json", HttpURLConnection.HTTP_OK)
        scoresListingViewModel.getScores()
        mockWebServer.takeRequest(4000, TimeUnit.MILLISECONDS)
        Assert.assertEquals(false, scoresListingViewModel.scoresList.isNotEmpty())
    }

    @Test
    fun test_product_listing_failure_case() = runBlocking{
        mockNetworkResponseWithFileContent("error.json", HttpURLConnection.HTTP_BAD_GATEWAY)
        scoresListingViewModel.getScores()
        mockWebServer.takeRequest(500, TimeUnit.MILLISECONDS)
        Assert.assertEquals(true, scoresListingViewModel.scoresList.isEmpty())
        scoresListingViewModel.getError().observeForever{
            Assert.assertEquals("Failed to get products", it?.errorMessage)
        }
    }


}