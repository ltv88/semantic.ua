package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import entity.TableRow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;


public class TablePage extends BasePage {

    public SideBar sideBar;

    public TablePage() {
        this.pageUrl = "/collections/table";
        this.sideBar = new SideBar();
    }

    ElementsCollection rows = $$("#example > div.pusher > div > div.article > div.main.ui.container > div:nth-child(13) > table > tbody > tr");

    private static List<TableRow> tableRows;

    public void setTableRows(ElementsCollection collection){
        tableRows = new ArrayList<>();
        for(SelenideElement elem : collection){
            String[] arr = elem.getAttribute("textContent").replaceAll("\\s+$", "").split("[\\r\\n]");
            tableRows.add(new TableRow(arr[1].replaceAll("^\\s+", ""), arr[2].replaceAll("^\\s+", ""), arr[3].replaceAll("^\\s+", "")));
        }
        System.out.println(":> "+Arrays.toString(tableRows.toArray()));
    }

    public ElementsCollection getRows(){
        rows.shouldBe(CollectionCondition.sizeGreaterThan(0));
        return rows;
    }

    public static List<TableRow> getTableRows() {
        return tableRows;
    }
}
