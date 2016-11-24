package br.com.mioto.sandboxes;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Class HelloController.
 */
@Controller
@RequestMapping("/")
public class HelloController {

    /** The facebook. */
    private Facebook facebook;
    
    /** The connection repository. */
    private ConnectionRepository connectionRepository;

    /**
     * Instantiates a new hello controller.
     *
     * @param facebook the facebook
     * @param connectionRepository the connection repository
     */
    public HelloController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    /**
     * Hello facebook.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping
    public String helloFacebook(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

        model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
        PagedList<Post> feed = facebook.feedOperations().getFeed();
        model.addAttribute("feed", feed);
        return "hello";
    }

}
