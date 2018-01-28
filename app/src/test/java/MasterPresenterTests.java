import com.samhalperin.cooperhewitt.application.CooperHewittApplication;
import com.samhalperin.cooperhewitt.data.models.detailobject.DetailObject;
import com.samhalperin.cooperhewitt.data.models.detailobject.Object;
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObject;
import com.samhalperin.cooperhewitt.data.repository.RepositoryContract;
import com.samhalperin.cooperhewitt.masterscreen.MasterContract;
import com.samhalperin.cooperhewitt.masterscreen.MasterPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

/**
 * Created by samhalperin on 1/28/18.
 */

public class MasterPresenterTests {
    private MasterPresenter mMasterPresenter;
    private SearchObject dummySearchObject1;
    private String id1 = "1";
    private String description1 = "A painting of fruit.";
    private SearchObject dummySearchObject2;
    private String id2 = "2";
    private String description2 = "A painting of a woman.";
    private List<SearchObject> dummySearchObjects;


    @Mock
    private RepositoryContract mRepository;

    @Mock
    private MasterContract.View mView;

    @Captor
    private ArgumentCaptor<RepositoryContract.NewSearchPageLoadedCallbacks> mSearchPageLoadedCaptor;

    @Before
    public void setupMasterPresenter() {
        MockitoAnnotations.initMocks(this);
        mMasterPresenter = new MasterPresenter(mView, mRepository);
        dummySearchObject1 = new SearchObject();
        dummySearchObject1.setId(id1);
        dummySearchObject1.setDescription(description1);
        dummySearchObject2 = new SearchObject();
        dummySearchObject2.setId(id2);
        dummySearchObject2.setDescription(description2);
        dummySearchObjects = new ArrayList();
        dummySearchObjects.add(dummySearchObject1);
        dummySearchObjects.add(dummySearchObject2);
    }

    @Test
    public void testAboutScreenNavigation() throws Exception {
        mMasterPresenter.navigateToAboutActivity();
        verify(mView).navigateToAboutActivity();
    }

    @Test
    public void testDetailScreenNavigation() throws Exception {
        String detailId = "1";
        mMasterPresenter.navigateToDetailActivity(detailId);
        verify(mView).navigateToDetailActivity(detailId);
    }

    void testSearchObjectLoad(boolean isFirstPage) {
        int dummyArtisticPeriod = 1234;
        mMasterPresenter.selectArtisticPeriod(dummyArtisticPeriod);
        mMasterPresenter.loadPage(1, true);
        verify(mRepository).getSearchPage(eq(1),
                eq(CooperHewittApplication.DEFAULT_PER_PAGE),
                eq(dummyArtisticPeriod),
                mSearchPageLoadedCaptor.capture());
        mSearchPageLoadedCaptor.getValue().onNewPageLoaded(dummySearchObjects);
        InOrder inOrder = Mockito.inOrder(mView);
        if (isFirstPage) {
            inOrder.verify(mView).clearResults();
        }
        inOrder.verify(mView).displayProgressBar();
        inOrder.verify(mView).displayPage(dummySearchObjects);
        inOrder.verify(mView).hideProgressBar();
    }

    @Test
    public void testLoadFirstPageOfSearchObjects() throws Exception {
        testSearchObjectLoad(true);
    }

    @Test
    public void testLoadSubsequentPageOfSearchObjects() throws Exception {
        testSearchObjectLoad(false);
    }
}
