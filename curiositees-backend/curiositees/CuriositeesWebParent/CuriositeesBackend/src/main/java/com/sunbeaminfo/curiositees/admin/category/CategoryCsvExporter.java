/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 07-08-2024, Wednesday
 * @Time : 12:27 am
 **/

package com.sunbeaminfo.curiositees.admin.category;

import com.curiositees.common.entity.Category;
import com.sunbeaminfo.curiositees.admin.user.export.AbstractExporter;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 07-08-2024, Wednesday
 **/

public class CategoryCsvExporter extends AbstractExporter {
  public void export(List<Category> listCategories, HttpServletResponse response)
      throws IOException {
    super.setResponseHeader(response, "text/csv", ".csv", "categories_");

    ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
        CsvPreference.STANDARD_PREFERENCE);

    String[] csvHeader = {"Category ID", "Category Name"};
    String[] fieldMapping = {"id", "name"};

    csvWriter.writeHeader(csvHeader);

    for (Category category : listCategories) {
      category.setName(category.getName().replace("--", "  "));
      csvWriter.write(category, fieldMapping);
    }

    csvWriter.close();
  }
}