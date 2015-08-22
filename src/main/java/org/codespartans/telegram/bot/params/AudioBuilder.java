package org.codespartans.telegram.bot.params;

import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.codespartans.telegram.bot.TelegramContentType;

/**
 * @author UnAfraid
 */
public class AudioBuilder extends AbstractParamBuilder<AudioBuilder>
{
	private static final String URL = "sendAudio";
	private static final Set<String> REQUIRED_FIELDS = new HashSet<>(Arrays.asList("chat_id", "audio"));
	
	/**
	 * @param chatId
	 */
	public AudioBuilder(int chatId)
	{
		super(chatId);
	}
	
	public AudioBuilder audioFile(String fileName)
	{
		return addGenericParam("audio", fileName);
	}
	
	public AudioBuilder audioFile(File file)
	{
		return addContentBodyParam("audio", new FileBody(file, TelegramContentType.MULTIPART_FORM_DATA, file.getName()));
	}
	
	public AudioBuilder audioStream(InputStream stream, String fileName)
	{
		return addContentBodyParam("audio", new InputStreamBody(stream, TelegramContentType.MULTIPART_FORM_DATA, fileName));
	}
	
	public AudioBuilder duration(int duration)
	{
		return addGenericParam("duration", duration);
	}
	
	public AudioBuilder performer(int performer)
	{
		return addGenericParam("performer", performer);
	}
	
	public AudioBuilder title(String title)
	{
		return addGenericParam("title", title);
	}
	
	@Override
	public String getURL()
	{
		return URL;
	}
	
	@Override
	public Set<String> getRequiredFields()
	{
		return REQUIRED_FIELDS;
	}
}