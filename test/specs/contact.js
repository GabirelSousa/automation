import ContactPage from "../pages/contact-page";

describe("Contact", () => {
  it("Fill the formulary and assert the success message", async () => {

    await ContactPage.open();
    await ContactPage.name.setValue("Gabriel");
    await ContactPage.email.setValue("meu@email.com");
    await ContactPage.phone.setValue("888888888");
    await ContactPage.message.setValue("any message");
    await ContactPage.submitBtn.click();

    await expect(ContactPage.successAlert).toHaveTextContaining(
      "Thanks for contacting us! We will be in touch with you"
    );
  });
});
