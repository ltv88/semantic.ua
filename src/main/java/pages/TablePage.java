package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import entity.TableRow;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TablePage {

    private static List<TableRow> tableRows;

    public void setTableRows(ElementsCollection collection){
        tableRows = new ArrayList<>();
        for(SelenideElement elem : collection){
            String[] arr = elem.getAttribute("textContent").replaceAll("\\s+$", "").split("[\\r\\n]");
            tableRows.add(new TableRow(arr[1].replaceAll("^\\s+", ""), arr[2].replaceAll("^\\s+", ""), arr[3].replaceAll("^\\s+", "")));
        }
        System.out.println(":> "+Arrays.toString(tableRows.toArray()));
    }

    public static List<TableRow> getTableRows() {
        return tableRows;
    }
}
