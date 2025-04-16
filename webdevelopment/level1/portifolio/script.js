// Smooth scroll for navigation links
document.querySelectorAll('a[href^="#"]').forEach(link => {
    link.addEventListener('click', function(e) {
      e.preventDefault();
      const target = document.querySelector(this.getAttribute('href'));
      if (target) {
        target.scrollIntoView({ behavior: 'smooth' });
      }
    });
  });
  
  // Alert when clicking resume link
  const resumeLink = document.querySelector('.resume a');
  resumeLink.addEventListener('click', () => {
    alert("Downloading Resume...");
  });
  
  // Set dynamic year in footer
  const footer = document.querySelector('footer p');
  const year = new Date().getFullYear();
  footer.innerHTML = `&copy; ${year} Moris Mutuma. All rights reserved.`;
  