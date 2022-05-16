class ContactPage {
    
  open() {
    return browser.url('/contact');
  }

  get name() {
    return $(".contact-name input");
  }

  get email() {
    return $(".contact-email input");
  }

  get phone() {
    return $(".contact-phone input");
  }

  get message() {
    return $(".contact-message textarea");
  }

  get submitBtn() {
    return $("button[type=submit]");
  }

  get successAlert() {
    return $("[role='alert']");
  }
}

export default new ContactPage();
