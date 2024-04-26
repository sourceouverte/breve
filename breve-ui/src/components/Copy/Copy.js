import React, { useState } from 'react';

function Copy({ text }) {
  const [isCopied, setIsCopied] = useState(false);

  const handleCopy = () => {
    navigator.clipboard.writeText(text)
      .then(() => {
        setIsCopied(true);
        setTimeout(() => { setIsCopied(false) }, 1500); // Reset feedback after 1.5 seconds
      })
      .catch(err => console.error('Error copying text: ', err));
  };

  return (
    <div>
      <button onClick={handleCopy}>
        {isCopied ? 'Copied!' : 'Copy'}
      </button>
    </div>
  );
}

export default Copy;
