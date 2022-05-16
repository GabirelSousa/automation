import BlogPage from "../pages/blog-page";

describe("Blog", () => {
  it("List of all recent post", async () => {
    await BlogPage.open();

    const recentPostList = await BlogPage.recentPostList;

    for (const item of recentPostList) {
      const text = await item.getText();
      console.log(text);
      expect(text.length).toBeGreaterThan(10);
    }

    expect(recentPostList).toHaveLength(5);

  });
});
