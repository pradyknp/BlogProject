package blog.data;

import blog.api.Blog;
import blog.api.Comment;

public interface BlogDAO {
	
	public void post(Blog blog);

	public Blog read(int id);

	public void addComment(Comment comment);
}
