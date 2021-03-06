package org.codespartans.telegram.bot.fluent;

import java.io.IOException;
import java.util.Optional;

import org.codespartans.telegram.bot.TelegramBot;
import org.codespartans.telegram.bot.models.Message;
import org.codespartans.telegram.bot.models.Reply;

/**
 * Created by ralph on 23/08/15.
 */
public class MessageRequest implements To<Object>, ReplyToMessage<Object>, ReplyMarkup<Object>, FromBot {
	private int chat_id;
	private String text;
	private Optional<String> parse_mode = Optional.empty();
	private Optional<Boolean> disable_web_page_preview = Optional.empty();
	private Optional<Integer> reply_to_message_id = Optional.empty();
	private Optional<Reply> reply_markup = Optional.empty();

	MessageRequest() {
	}

	public MessageRequest to(int chatId) {
		this.chat_id = chatId;
		return this;
	}

	public MessageRequest withText(String text) {
		this.text = text;
		return this;
	}

	public MessageRequest withoutWebPagePreview() {
		this.disable_web_page_preview = Optional.of(true);
		return this;
	}

	public MessageRequest isReplyToMessage(int chatId) {
		this.reply_to_message_id = Optional.of(chatId);
		return this;
	}

	public MessageRequest andReplyMarkup(Reply reply) {
		this.reply_markup = Optional.of(reply);
		return this;
	}

	public MessageRequest withMarkdown(String markDown) {
		this.parse_mode = Optional.of(markDown);
		return this;
	}

	public Message fromBot(String token) throws IOException {
		return fromBot(TelegramBot.getInstance(token));
	}

	public Message fromBot(TelegramBot bot) throws IOException {
		return bot.sendMessage(chat_id, text, parse_mode, disable_web_page_preview, reply_to_message_id, reply_markup);
	}
}
