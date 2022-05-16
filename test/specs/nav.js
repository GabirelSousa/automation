import HomePage from "../pages/home-page";

describe("navPage", () => {
  it("Assert Navegation Menu", async () => {
    await HomePage.open();

    const expectedLinks = [
      "Home",
      "About",
      "Shop",
      "Blog",
      "Contact",
      "My account",
    ];
    const actualLinks = [];
    const navLinks = await HomePage.navComponent.linksNavMenu;

    for (const link of navLinks) {
      actualLinks.push(await link.getText());
    }

    expect(expectedLinks).toEqual(actualLinks);
  });
});
