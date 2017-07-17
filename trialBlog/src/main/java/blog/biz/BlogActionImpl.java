package blog.biz;

import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import blog.api.Blog;
import blog.api.BlogAction;

@XmlRootElement
@Entity
public class BlogActionImpl implements BlogAction{

	@Override
	public Blog post(Blog blog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blog update(Blog blog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blog view(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}

}
