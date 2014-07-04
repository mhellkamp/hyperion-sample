package smoketest;

import com.dottydingo.hyperion.api.EntityResponse;
import com.dottydingo.hyperion.client.HyperionClient;
import com.dottydingo.hyperion.client.builder.*;
import com.dottydingo.hyperion.api.exception.HyperionException;
import com.dottydingo.hyperion.northwind.api.Category;


/**
 */
public class SmokeTest
{
    public static void main(String[] args) throws Exception
    {
        HyperionClient client = new HyperionClient("http://localhost:8080/data",new MyAuthorizationFactory());
        client.setClientEventListener(new MyEventListener());

        RequestFactory<Category,Long> factory = new RequestFactory<Category, Long>(1,Category.class);

        Category category = new Category();
        category.setCategoryName("my new foo");
        category.setImageUrl("http://foo");
        category = factory.create(category)
                .returnFields("id", "categoryName")
                .execute(client);

        System.out.println(category.getId());

        EntityResponse<Category> cats = factory.find(category.getId()).returnFields("id","categoryName").execute(client);
        System.out.println(cats.getResponseCount());
        System.out.println(cats.getEntries().get(0).getId() + " " + cats.getEntries().get(0).getCategoryName());

        category.setCategoryName("some other x");
        Category updated = factory.update(category).execute(client);
        System.out.println(updated.getCategoryName());


        System.out.println(factory.delete(updated.getId()).execute(client));

        cats = factory.find(updated.getId()).execute(client);
        System.out.println(cats.getResponseCount());

        cats = factory.query("id=gt=1")
                .start(1L)
                .limit(9L)
                .returnFields("id","categoryName")
                .addDescendingSort("id")
                .execute(client);

        for (Category c : cats.getEntries())
        {
            System.out.printf("%s - %s\n", c.getId(), c.getCategoryName());
        }

        cats = factory.query("id=gt=1")
                .start(1L)
                .limit(9L)
                .returnFields("id","categoryName")
                .addAscendingSort("categoryName")
                .addDescendingSort("id")
                .execute(client);

        for (Category c : cats.getEntries())
        {
            System.out.printf("%s - %s\n", c.getId(), c.getCategoryName());
        }

        category = new Category();
        category.setCategoryName("error");

        try
        {
            category = factory.create(category)
                    .returnFields("id", "categoryName")
                    .execute(client);
        }
        catch (HyperionException e)
        {
            e.printStackTrace();
        }

    }
}
