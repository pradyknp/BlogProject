package blog.api;

import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public interface BlogAction {
	Blog post(Blog blog);
	Blog update(Blog blog);
	Blog view(int blogId);
//	void delete(int blogId);
//	List<Blog> viewAll();
//	List<Blog> findByUserName(String userName);
//	List<Blog> findByCategory(String category);
//	List<Blog> search(String searchText);
}
