package blog.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import blog.api.Blog;
import blog.api.Comment;



public class InMemoryBlogDAO implements BlogDAO {

//	Map<Integer, Blog> stock = new HashMap<>();
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("trialblog");
	EntityManager stock = factory.createEntityManager();
	

	@Override
	public void post(Blog blog) {
		
		if(stock.getTransaction().isActive())
			stock.getTransaction().rollback();
		
		stock.getTransaction().begin();
		stock.persist(blog);
		stock.getTransaction().commit();
	}

	@Override
	public Blog read(int id) {
		return stock.find(Blog.class,id);
	}
	
	@Override
	public void addComment(Comment comment) {
		
		if(stock.getTransaction().isActive())
			stock.getTransaction().rollback();
		
		stock.getTransaction().begin();
		stock.persist(comment);
		stock.getTransaction().commit();
	}

}
