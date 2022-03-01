# 3. Use GitHub Flow

Date: 2022-02-28

## Status

Accepted

## Context

The project needs a Git branching model that will support releases, release patching, and ongoing
development. It should be simple, idiomatic, and be publicly documented. We shouldn't re-invent the wheel, nor should we
[bike shed](https://en.wikipedia.org/wiki/Law_of_triviality) edge cases that are high in complexity, low in value.

I/Kenneth have been using the popular [A Successful Git Branching
Model](https://nvie.com/posts/a-successful-git-branching-model/), but it adds complexity that a single developer project
doesn't need.

## Decision

We will use [GitHub Flow](https://docs.github.com/en/get-started/quickstart/github-flow), a lightweight branch based workflow.

## Consequences

Branching is easy and supports the requirements of a demo project like this. The method is popular, well documented, and
has a history of success.
