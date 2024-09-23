const { default: ItemsAccordion } = require("@/app/components/Accordion")

describe('Accordion.cy.jsx', () => {
  it('playground', () => {
    cy.mount(<ItemsAccordion items={[]}/>)
  })
})