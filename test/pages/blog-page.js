class BlogPage {

    open(){
        return browser.url('/blog');
    }

    get recentPostList (){
        return $$('#recent-posts-3 ul li');
    }    
    
}

export default new BlogPage(); 