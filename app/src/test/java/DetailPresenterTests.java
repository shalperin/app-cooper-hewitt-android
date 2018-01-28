import com.samhalperin.cooperhewitt.data.models.detailobject.DetailObject;
import com.samhalperin.cooperhewitt.data.models.detailobject.Object;
import com.samhalperin.cooperhewitt.data.repository.RepositoryContract;
import com.samhalperin.cooperhewitt.detailscreen.DetailContract;
import com.samhalperin.cooperhewitt.detailscreen.DetailPresenter;


import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

/**
 * Created by samhalperin on 1/28/18.
 */

public class DetailPresenterTests {
    private DetailPresenter mDetailPresenter;
    private DetailObject dummyDetailObject;
    private String dummyDetailObjectId = "1";
    private String dummyDetailObjectDescription = "A piece of art.";

    @Mock
    private RepositoryContract mRepository;

    @Mock
    private DetailContract.View mView;

    @Captor
    private ArgumentCaptor<RepositoryContract.DetailObjectLoadedCallbacks> mDetailObjectLoadedCallbacksArgumentCaptor;

    @Before
    public void setUpPresenter() {
        MockitoAnnotations.initMocks(this);
        mDetailPresenter = new DetailPresenter(mView, mRepository);
        dummyDetailObject = new DetailObject();
        Object dummyDetailInnerObject = new Object();
        dummyDetailInnerObject.setId(dummyDetailObjectId);
        dummyDetailInnerObject.setDescription(dummyDetailObjectDescription);
        dummyDetailObject.setObject(dummyDetailInnerObject);
    }

    @Test
    public void testLoadDetailObject() throws Exception {
        mDetailPresenter.loadDetailObject(dummyDetailObjectId);
        verify(mRepository).getDetailObject(eq(dummyDetailObjectId), mDetailObjectLoadedCallbacksArgumentCaptor.capture());
        mDetailObjectLoadedCallbacksArgumentCaptor.getValue().onDetailObjectLoaded(dummyDetailObject);
        InOrder inOrder = Mockito.inOrder(mView);
        inOrder.verify(mView).displayDetailObject(dummyDetailObject);
    }

    @Test
    public void testShare() throws Exception {
        mDetailPresenter.shareDetailObject(dummyDetailObjectId);
        verify(mRepository).getDetailObject(eq(dummyDetailObjectId), mDetailObjectLoadedCallbacksArgumentCaptor.capture());
        mDetailObjectLoadedCallbacksArgumentCaptor.getValue().onDetailObjectLoaded(dummyDetailObject);
        verify(mView).shareDetailObject(dummyDetailObject);
    }
}
