package blog.biz;



import blog.api.Blog;
import blog.api.BlogAction;
import blog.api.Comment;
import blog.api.exception.BlogNotFoundException;
import blog.api.exception.InvalidBlogException;
import blog.data.BlogDAO;
import blog.data.InMemoryBlogDAO;
import java.util.List;;

public class BlogActionImpl implements BlogAction{
	BlogDAO dao = new InMemoryBlogDAO();

	@Override
	public void post(Blog blog) {
		
		if(blog == null || blog.getId() < 1 || blog.getTitle() == null || blog.getTitle().trim().length()==0 || blog.getTitle().trim().length() > 64 || blog.getBody().trim().length() == 0)
			throw new InvalidBlogException();
		
		dao.post(blog);
	}

	@Override
	public Blog update(Blog blog) {
		Blog blogupdate= dao.read(blog.getId());
		if(blogupdate == null)
			throw new BlogNotFoundException();
		
		dao.post(blogupdate);
		
		return blog;
	}

	@Override
	public Blog view(int blogId) {
		
		Blog blog= dao.read(blogId);
		if(blog == null)
			throw new BlogNotFoundException();
		
		return blog;
	}
	
	@Override
	public void postComment(Comment comment) {
		if(comment == null)
			throw new BlogNotFoundException();
		
		dao.addComment(comment);
		
	}
	
	@Override
	public List<Blog> viewAll() {
		List<Blog> blogs = dao.readAll();
		
		if(blogs == null)
			throw new BlogNotFoundException();
		
		return blogs;
	}

}
