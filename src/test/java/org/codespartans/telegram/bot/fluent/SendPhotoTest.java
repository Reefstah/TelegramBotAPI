package org.codespartans.telegram.bot.fluent;

import org.codespartans.telegram.bot.IntegrationTests;
import org.codespartans.telegram.bot.models.Message;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.io.IOException;

/**
 * Created by ralph on 24/08/15.
 */
@Category({IntegrationTests.class, FluentIntegrationTests.class})
public class SendPhotoTest {

    private static final String TOKEN = System.getenv("TOKEN");
    private static final int GROUP_CHAT_ID = Integer.valueOf(System.getenv("GROUP_CHAT_ID"));

    @Test
    public void sendPhoto() throws IOException {
        File file = new File(this.getClass().getResource("/5411648.png").getPath());
        final String caption = "Fluently send photo.";

        Message message = SendPhoto
                .to(GROUP_CHAT_ID)
                .photo(file)
                .withCaption(caption)
                .fromBot(TOKEN);

        Assert.assertNotNull(message);
        Assert.assertNotNull(message.getCaption());
        Assert.assertEquals(message.getCaption().get(), caption);
    }
}
