package ru.job4j.condition;

import org.junit.Test;
import ru.job4j.condition.DummyBot;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author ism.vladimir
 * @version $Id$
 * @since 0.1
 */
public class DummyBotTest {
    @Test
    public void whenGreatBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Привет, Бот"),
                is("Привет, умник!")
        );
    }

    @Test
    public void whenByeBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Пока"),
                is("До скорой встречи!")
        );
    }

    @Test
    public void whenUnknownBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Кто победит в ЧМ 2018?"),
                is("Это ставит меня в тупик, задайте другой вопрос")
        );
    }
}
