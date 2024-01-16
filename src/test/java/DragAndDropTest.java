import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    SelenideElement a = $("#column-a");
    SelenideElement b = $("#column-b");

    @BeforeEach
    void setUp() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        a.shouldHave(Condition.text("A"));
        b.shouldHave(Condition.text("B"));
    }

    @Test
    void dragAndDropFigureByActions() {
        actions().dragAndDrop(a, b).perform();
        a.shouldHave(Condition.text("B"));
        b.shouldHave(Condition.text("A"));
    }

    @Test
    void dragAndDropFigureByElementDragAndDrop() {
        a.dragAndDrop(to(b));
        a.shouldHave(Condition.text("B"));
        b.shouldHave(Condition.text("A"));
    }
}