package blog.api;


import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import blog.api.exception.BlogException;
import blog.api.exception.BlogNotFoundException;
import blog.api.exception.DuplicateBlogException;
import blog.api.exception.InvalidBlogException;
import java.util.List;

public interface BlogAction {
	void post(Blog blog) throws DuplicateBlogException,InvalidBlogException, BlogException;
	Blog update(Blog blog) throws BlogNotFoundException,InvalidBlogException,BlogException;
	Blog view(int blogId) throws DuplicateBlogException,InvalidBlogException,BlogException;
	void postComment(Comment comment);
	
//	void delete(int blogId);
	List<Blog> viewAll();
//	List<Blog> findByUserName(String userName);
//	List<Blog> findByCategory(String category);
//	List<Blog> search(String searchText);
}
