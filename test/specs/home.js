import HomePage from "../pages/home-page";

describe("home page", () => {
  it("open webpage and assert title", async () => {
    //Open URL
    await HomePage.open();

    //Assert Title
    await expect(browser).toHaveTitle(
      "Practice E-Commerce Site – Automation Bro"
    );
  });
});
