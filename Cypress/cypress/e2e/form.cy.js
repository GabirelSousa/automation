describe('Form test',()=>{

    beforeEach(()=>{
        cy.visit('/forms')
    })
    it('Check header',()=>{
        cy.getDataTest('Forms header').should('be.visible')
    })
    it('Accordion item 1 works correctly',()=>{
        cy.isNotVisibleText('First, we need to get the form')
        cy.getDataTest('accordion-item-1').click()
        cy.isVisibleText('First, we need to get the form')
        cy.getDataTest('accordion-item-1').click()
        cy.isNotVisibleText('First, we need to get the form')
    })
    it('Accordion item 2 works correctly',()=>{
        cy.isNotVisibleText("cy.type('words')")
        cy.getDataTest('accordion-item-2').click()
        cy.isVisibleText("cy.type('words')")
        cy.getDataTest('accordion-item-2').click()
        cy.isNotVisibleText("cy.type('words')")
    })
    it('Accordion item 3 works correctly',()=>{
        cy.isNotVisibleText("cy.click()")
        cy.getDataTest('accordion-item-3').click()
        cy.isVisibleText("cy.click()")
        cy.getDataTest('accordion-item-3').click()
        cy.isNotVisibleText("cy.click()")
    })
    it('Accordion item 4 works correctly',()=>{
        cy.isNotVisibleText("NOTE: Waiting/Retriability *docs")
        cy.getDataTest('accordion-item-4').click()
        cy.isVisibleText("NOTE: Waiting/Retriability *docs")
        cy.getDataTest('accordion-item-4').click()
        cy.isNotVisibleText("NOTE: Waiting/Retriability *docs")
    })
    it('Check email input field works correctly',()=>{
        cy.contains('Invalid email: !').should('not.exist')
        cy.contains("Successfully subbed: gabriel@gmail.com!").should('not.exist')
        cy.contains("Invalid email: gabriel@gmail.io!").should('not.exist')

        cy.inputText('email field','gabriel@gmail.com')
        cy.getDataTest('Button').click()
        cy.contains("Successfully subbed: gabriel@gmail.com!").should('exist')
        cy.wait(3000)
        cy.contains("Successfully subbed: gabriel@gmail.com!").should('not.exist')

        cy.getDataTest('Button').click()
        cy.contains("Invalid email: !").should('exist')
        cy.wait(3000)
        cy.contains("Invalid email: !").should('not.exist')

        cy.inputText('email field','gabriel@gmail.io')
        cy.getDataTest('Button').click()
        cy.contains("Invalid email: gabriel@gmail.io!").should('exist')
        cy.wait(3000)
        cy.contains("Invalid email: gabriel@gmail.io!").should('not.exist')

    })
})