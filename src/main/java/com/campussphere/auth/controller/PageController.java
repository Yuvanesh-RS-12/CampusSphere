package com.campussphere.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Serves the server-rendered HTML views for Phase 1: the public landing
 * page, the registration page, Spring Security's login page, and the
 * post-login dashboard placeholder.
 *
 * Kept separate from AuthController (which handles JSON API calls) so
 * that view-serving and API logic are not mixed in the same class.
 */
@Controller
public class PageController {

    /**
     * Public landing page. Accessible without authentication.
     */
    @GetMapping("/")
    public String home() {
        return "index";
    }

    /**
     * Registration page. The form on this page submits via JavaScript
     * (auth.js) to POST /api/auth/register.
     */
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    /**
     * Custom login page, referenced from SecurityConfig via
     * .loginPage("/login"). Spring Security handles the actual
     * POST /login submission automatically.
     */
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    /**
     * Landing page after a successful login. Later phases will replace
     * this placeholder with real module content (listings, notifications,
     * etc.) once Marketplace, Freelance, Guidance, and Lost & Found exist.
     */
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
