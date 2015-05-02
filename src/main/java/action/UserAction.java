package action;

import entity.Book;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.MailService;
import service.UserHttpService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by reeco_000 on 2015/4/18.
 */

@Controller
@RequestMapping("/user")
@EnableWebMvc
public class UserAction {

    private MailService mailService;

    private UserHttpService userHttpService;

    private UserService userService;

    private List<Book> books = new ArrayList<Book>();

    //private User user = new User();

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserHttpService(UserHttpService userHttpService) {
        this.userHttpService = userHttpService;
    }

    @Autowired
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        request.getSession().setAttribute("sUser", user);
        Boolean check = userHttpService.login(username, password);
        if (check) {
            if (!books.isEmpty())
                books.clear();
            books = userHttpService.getBooks(username, password);
            setBooks(books);
            // model.addAttribute("books", books);
            request.getSession().setAttribute("books", books);
            //   redirectAttributes.addAttribute("books",books);
//            System.out.println(books.size());
            return "redirect:/user/book";
        } else {
            System.out.println("密码错误");
            redirectAttributes.addFlashAttribute("message", "账号或者密码错误，请检查");
            return "redirect:/";
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String add(HttpServletRequest request, RedirectAttributes redirectAttributes) {

        String email = request.getParameter("email");
        User user = (User) request.getSession().getAttribute("sUser");
        user.setEmail(email);
        user.setFlag(1);
        user.setTest_email(0);
        Boolean temp = userService.isEmail(email);
        if (temp) {
            redirectAttributes.addFlashAttribute("message", "邮箱已被注册");
            return "redirect:/user/book";
        } else {

            temp = userService.isExist(user.getUsername());
            if (temp) {
                redirectAttributes.addFlashAttribute("already", "此用户名已经注册");
                return "redirect:/user/book";
            }
            userService.addUser(user, books);
            mailService.sendTestMailByGun(books, email);
            redirectAttributes.addFlashAttribute("succ", "注册成功，不出意外您将收到一封测试邮件，若是QQ用户，请检查您的垃圾箱");

            return "redirect:/user/book";
        }
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/book")
    public String bookList() {
        return "book";
    }
}
