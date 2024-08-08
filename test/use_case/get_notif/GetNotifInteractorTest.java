package use_case.get_notif;

import data_access.UserDAOInterface;
import entity.user.AdopterUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class GetNotifInteractorTest {
    private UserDAOInterface userDAO;
    private GetNotifOutputBoundary presenter;
    private GetNotifInteractor interactor;

    @BeforeEach
    void setUp() {
        userDAO = Mockito.mock(UserDAOInterface.class);
        presenter = Mockito.mock(GetNotifOutputBoundary.class);
        interactor = new GetNotifInteractor(userDAO, presenter);
    }

    @Test
    void testExecuteNoNotifications() {
        AdopterUser user = new AdopterUser("user1", "password", "User One", "email1@example.com", "123");
        when(userDAO.get("user1")).thenReturn(user);

        GetNotifInputData inputData = new GetNotifInputData("user1");
        interactor.execute(inputData);

        ArgumentCaptor<GetNotifOutputData> argumentCaptor = ArgumentCaptor.forClass(GetNotifOutputData.class);
        verify(presenter).updateNotif(argumentCaptor.capture());

        GetNotifOutputData outputData = argumentCaptor.getValue();
        assertEquals(0, outputData.getNotif().size());
    }

    @Test
    void testExecuteWithNotifications() {
        AdopterUser user = new AdopterUser("user1", "password", "User One", "email1@example.com", "123");
        user.addNotif("Notification 1");
        user.addNotif("Notification 2");

        when(userDAO.get("user1")).thenReturn(user);

        GetNotifInputData inputData = new GetNotifInputData("user1");
        interactor.execute(inputData);

        ArgumentCaptor<GetNotifOutputData> argumentCaptor = ArgumentCaptor.forClass(GetNotifOutputData.class);
        verify(presenter).updateNotif(argumentCaptor.capture());

        GetNotifOutputData outputData = argumentCaptor.getValue();
        List<String> notifications = outputData.getNotif();

        assertEquals(2, notifications.size());
        assertEquals("Notification 1", notifications.get(0));
        assertEquals("Notification 2", notifications.get(1));
    }
}
