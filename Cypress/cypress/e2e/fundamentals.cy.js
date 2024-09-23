describe('Fundamentals test', () => {

  beforeEach(()=>{
    cy.visit('/fundamentals')
  })
  it('Contains correct header text', () => {
    cy.getDataTest('fundamentals-header').should('contain.text','Testing Fundamentals')
    
  })
  it('Accordion item 1 works correctly',()=>{
    cy.isNotVisibleText('Your tests will exist in a describe block')
    cy.get('[data-test="accordion-item-1"] div[role="button"]').click()
    cy.isVisibleText('Your tests will exist in a describe block')
    cy.get('[data-test="accordion-item-1"] div[role="button"]').click()
    cy.isNotVisibleText('Your tests will exist in a describe block')
  })
  it('Accordion item 2 works correctly',()=>{
    cy.isNotVisibleText('Within your describe block, you will also have it blocks')
    cy.get('[data-test="accordion-item-2"] div[role="button"]').click()
    cy.contains(/Within your describe block, you will also have it blocks/i).should('be.visible')
    cy.get('[data-test="accordion-item-2"] div[role="button"]').click()
    cy.isNotVisibleText('Within your describe block, you will also have it blocks')
  })
  it('Accordion item 3 works correctly',()=>{
    cy.isNotVisibleText('Cypress gives you various commands to help you test') 
    cy.get('[data-test="accordion-item-3"] div[role="button"]').click()
    cy.contains(/Cypress gives you various commands to help you test/i).should('be.visible')
    cy.get('[data-test="accordion-item-3"] div[role="button"]').click()
    cy.isNotVisibleText('Cypress gives you various commands to help you test')
    
  })
  it('Accordion item 4 works correctly',()=>{
    cy.isNotVisibleText("You're often going to want to get an element from the DOM and make some sort of assertion")
    cy.get('[data-test="accordion-item-4"] div[role="button"]').click()
    cy.contains(/You're often going to want to get an element from the DOM and make some sort of assertion/i).should('be.visible')
    cy.get('[data-test="accordion-item-4"] div[role="button"]').click()
    cy.isNotVisibleText("You're often going to want to get an element from the DOM and make some sort of assertion")
  })
  it('Accordion item 5 works correctly',()=>{
    cy.isNotVisibleText('After you get an element, you probably want to do something with that element, like make an assertion.')
    cy.get('[data-test="accordion-item-5"] div[role="button"]').click()
    cy.contains(/After you get an element, you probably want to do something with that element, like make an assertion./i).should('be.visible')
    cy.get('[data-test="accordion-item-5"] div[role="button"]').click()
    cy.isNotVisibleText('After you get an element, you probably want to do something with that element, like make an assertion.')
  })
  it('Accordion item 6 works correctly',()=>{
    cy.isNotVisibleText('You can use')
    cy.get('[data-test="accordion-item-6"] div[role="button"]').click()
    cy.contains(/You can use it./i).should('be.visible')
    cy.get('[data-test="accordion-item-6"] div[role="button"]').click()
    cy.isNotVisibleText('You can use it.')
  })
  it('Accordion item 7 works correctly',()=>{
    cy.isNotVisibleText('You can use a beforeEach function to perform certain actions prior to every test')
    cy.get('[data-test="accordion-item-7"] div[role="button"]').click()
    cy.contains(/You can use a beforeEach function to perform certain actions prior to every test/i).should('be.visible')
    cy.get('[data-test="accordion-item-7"] div[role="button"]').click()
    cy.isNotVisibleText('You can use a beforeEach function to perform certain actions prior to every test')
  })
  it('Accordion item 8 works correctly',()=>{
    cy.isNotVisibleText("You aren't limited to just the cy.X commands, but you can create your own custom commands")
    cy.get('[data-test="accordion-item-8"] div[role="button"]').click()
    cy.contains(/You aren't limited to just the cy.X commands, but you can create your own custom commands/i).should('be.visible')
    cy.get('[data-test="accordion-item-8"] div[role="button"]').click()
    cy.isNotVisibleText("You aren't limited to just the cy.X commands, but you can create your own custom commands/i")
  })
})