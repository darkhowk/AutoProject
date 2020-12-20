package auto.telegram.main;

import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class TelegramTest extends TelegramLongPollingBot {

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onUpdateReceived(Update arg0) {
		 // TODO Auto-generated method stub
        System.out.println(arg0.getMessage().getFrom().getId()); //get ID 는 suer id
        System.out.println(arg0.getMessage().getFrom().getFirstName()); //get ID 는 suer id
        System.out.println(arg0.getMessage().getFrom().getLastName()); //get ID 는 suer id
        System.out.println(arg0.getMessage().getChatId());  // 채팅방의 ID
        System.out.println(arg0.getMessage().getText());  // 받은 TEXT
        System.out.println(arg0.getMessage().getReplyToMessage().getText());  // bot이 물어 본 받은 TEXT 사용자가 봇에게 답장 할때 사용
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return null;
	}

}
